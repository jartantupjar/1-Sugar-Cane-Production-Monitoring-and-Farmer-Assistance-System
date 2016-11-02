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
            CropAssessment ca = new CropAssessment(); //for area
            CropAssessment ca2 = new CropAssessment(); // for tons cane
            CropAssessmentDB cadb = new CropAssessmentDB();
            ArrayList<CropAssessment> caT = new ArrayList<CropAssessment>(); //the whole report itself
            ArrayList<CropAssessment> prevT = new ArrayList<CropAssessment>(); // gets the previous of area and tc
            ArrayList<CropAssessment> currT = new ArrayList<CropAssessment>(); // gets the current of area and tc
            User successful = myUserDB.authenticate(oneUser);
            if (successful != null) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Homepage.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("user", successful); 
                //start of the crop assessment report
                String sdate = "2015-02-10"; // date of the login
                Date todayDate = Date.valueOf(sdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(todayDate);
                int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
                System.out.println(week_of_year);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                ArrayList<CropAssessment> rain = cadb.getRainFall(week_of_year,year);
                DecimalFormat df = new DecimalFormat("#.##");   
                currT = cadb.getCropAssessmentReportForTheWeek(week_of_year, year);
                prevT = cadb.getPrevCropAssessmentReportForTheWeek(week_of_year, year);
                double etc = Double.valueOf(df.format(cadb.getTotalEstimatedTonsCane(year)));
                double eah = Double.valueOf(df.format(cadb.getTotalEstimatedArea(year)));
                Date week_ending = currT.get(0).getWeek_ending();
                    ca.setParticulars("Area");
                    ca.setEstimated(eah);
                    ca.setPrevious(prevT.get(0).getPrevArea());
                    ca.setThisweek(currT.get(0).getThisArea());
                    double todate = ca.getPrevious() + ca.getThisweek();
                    ca.setTodate(todate);
                    double percenta = 0;
                    double percentb = 0;
                    percenta = Double.valueOf(df.format((ca.getTodate()/eah)*100));
                    ca.setPercent(percenta);
                    ca.setStanding(Double.valueOf(df.format(ca.getEstimated()- ca.getTodate())));
                    caT.add(ca);
                    ca2.setParticulars("Tons Cane");
                    ca2.setEstimated(etc);
                    ca2.setPrevious(prevT.get(0).getPrevTons_Cane());
                    ca2.setThisweek(currT.get(0).getThisTons_Cane());
                    double todate2 = ca2.getPrevious() +ca2.getThisweek();
                    ca2.setTodate(todate2);
                    percentb = Double.valueOf(df.format((ca2.getTodate()/etc)*100));
                    ca2.setPercent(percentb);
                    ca2.setStanding(Double.valueOf(df.format(ca2.getEstimated()- ca2.getTodate())));
                    caT.add(ca2);
                    System.out.println(rain.get(0).getRainfall()+ "RAINFALL");
                     CropNarrative cn=null;
                 if(cadb.checkExistingNarrative(year,week_ending)==true){ 
                     System.out.println("it entered tester");
                     cn=new CropNarrative();
           cn=cadb.getAssessmentNarrative(year,week_ending);
//                  
                 }
                session.setAttribute("narrative", cn);
                session.setAttribute("Week_ending", week_ending);
                session.setAttribute("todayDate", todayDate);
                session.setAttribute("CropAss", caT);
                session.setAttribute("todayYear", year);
                session.setAttribute("todayMonth", month);
                session.setAttribute("todayDay", day);
                session.setAttribute("rainfall", rain);
                session.setAttribute("weekOfYear", week_of_year);
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
