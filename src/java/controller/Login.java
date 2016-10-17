package controller;


import db.CropAssessmentDB;
import db.UsersDB;
import entity.CropAssessment;
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
            CropAssessment ca = new CropAssessment();
            CropAssessment ca2 = new CropAssessment();
            CropAssessmentDB cadb = new CropAssessmentDB();
            ArrayList<CropAssessment> caT = new ArrayList<CropAssessment>();
            ArrayList<CropAssessment> prevT = new ArrayList<CropAssessment>();
            ArrayList<CropAssessment> currT = new ArrayList<CropAssessment>();
            User successful = myUserDB.authenticate(oneUser);
            if (successful != null) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Homepage.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("user", successful);
                String sdate = "2015-02-10";
                Date todayDate = Date.valueOf(sdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(todayDate);
                int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
                int year = cal.get(Calendar.YEAR);
                DecimalFormat df = new DecimalFormat("#.##");   
                currT = cadb.getCropAssessmentReportForTheWeek(week_of_year, year);
                prevT = cadb.getPrevCropAssessmentReportForTheWeek(week_of_year, year);
                    ca.setParticulars("Area");
                    ca.setPrevArea(prevT.get(0).getPrevArea());
                    ca.setThisArea(currT.get(0).getThisArea());
                    double todate = prevT.get(0).getPrevArea() + currT.get(0).getThisArea();
                    ca.setTodateArea(todate);
                    double percent = 0;
                    percent = Double.valueOf(df.format(prevT.get(0).getPrevArea() / currT.get(0).getThisArea()));
                    ca.setPercArea(percent);
                    caT.add(ca);
                    ca2.setParticulars("Tons Cane");
                    ca2.setPrevArea(prevT.get(0).getPrevTons_Cane());
                    ca2.setThisArea(currT.get(0).getThisTons_Cane());
                    todate = prevT.get(0).getPrevTons_Cane() +currT.get(0).getThisTons_Cane();
                    ca2.setTodateArea(todate);
                    percent = Double.valueOf(df.format(prevT.get(0).getPrevTons_Cane()/currT.get(0).getThisTons_Cane()));
                    ca2.setPercArea(percent);
                    caT.add(ca2);
                session.setAttribute("todayDate", todayDate);
                session.setAttribute("CropAss", caT);
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
