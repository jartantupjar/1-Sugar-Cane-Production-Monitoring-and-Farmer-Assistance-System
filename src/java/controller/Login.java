package controller;

import db.CropAssessmentDB;
import db.UsersDB;
import entity.CropAssessment;
import entity.CropNarrative;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            User oneUser = new User();
            oneUser.setUsername(request.getParameter("username"));
            oneUser.setPassword(request.getParameter("password"));
            UsersDB myUserDB = new UsersDB();
            CropAssessmentDB cadb = new CropAssessmentDB();
            User successful = myUserDB.authenticate(oneUser);
            if (successful != null) {

                ServletContext context = getServletContext();
                HttpSession session = request.getSession();
                //start of the crop assessment report
                String sdate = "2015-02-10"; // date of the login-- change this to the parameter date
                Date todayDate = Date.valueOf(sdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(todayDate);
                int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
                System.out.println(week_of_year);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                ArrayList<CropAssessment> caT = new ArrayList<CropAssessment>();
                caT = cadb.getCropAssesmentRajversion(week_of_year, year);
                Date week_ending = caT.get(0).getWeek_ending();

                session.setAttribute("Week_ending", week_ending);
                session.setAttribute("todayDate", todayDate);
                session.setAttribute("todaysDate", todayDate);
                session.setAttribute("todayYear", year);
                session.setAttribute("todayMonth", month);
                session.setAttribute("todayDay", day);
                session.setAttribute("weekOfYear", week_of_year);
                RequestDispatcher rd = null;
                if (successful.getGroup().equalsIgnoreCase("MDO")) {

                    rd = context.getRequestDispatcher("/Homepage.jsp");
                    CropNarrative cn = null;

                    ArrayList<CropAssessment> rain = cadb.getRainFall(week_of_year, year);

                    if (cadb.checkExistingNarrative(year, week_ending) == true) {
                        System.out.println("it entered tester");
                        cn = new CropNarrative();
                        cn = cadb.getAssessmentNarrative(year, week_ending);

//                  
                    }
                    session.setAttribute("rainfall", rain);
                    session.setAttribute("narrative", cn);
                    session.setAttribute("CropAss", caT);

                } else if (successful.getGroup().equalsIgnoreCase("Board")) {
                    rd = context.getRequestDispatcher("/Homepage_Board.jsp");

                }

                session.setAttribute("user", successful);
                rd.forward(request, response);
            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
