/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.FarmsDB;
import db.ProblemsDB;
import db.fixedRecDB;
import entity.Farm;
import entity.Problems;
import entity.Recommendation;
import entity.compProblems;
import entity.compRecommendation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ndrs
 */
public class viewFarmDifferences extends BaseServlet {

   
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        FarmsDB farmdb = new FarmsDB();

        HttpSession session = request.getSession();
       
           String id = request.getParameter("id");
            String tag = request.getParameter("taglist");
             System.out.println(tag+": this tag m8");
             String[] tags = tag.split(",");
           
      Enumeration<String> parameterNames = request.getParameterNames();
            String paramName;
            
            ArrayList<String> fids = new ArrayList<>();
            while (parameterNames.hasMoreElements()) {
                 paramName = parameterNames.nextElement();
//               System.out.println(paramName+"da paramname");
            if (paramName.startsWith("fids")) {
                for(int i=0;i<request.getParameterValues(paramName).length;i++){
                  String paramlist= request.getParameterValues(paramName)[i];
                    if(!paramlist.equals(id)){
                        fids.add(paramlist);
                    }    
     //            System.out.println(request.getParameterValues(paramName)[i]);
                }
             }
          }
          ArrayList<Farm> list=farmdb.getAllFieldComp(fids);
         Farm farm=farmdb.getAllFieldDetails(Integer.parseInt(id));
         ArrayList<Farm> dalist= new ArrayList<>();
         ArrayList<Farm> dalist2= new ArrayList<>();
         ArrayList<Farm> dalist3= new ArrayList<>();
              dalist.addAll(list);
              dalist2.addAll(list);
              dalist3.addAll(list);
              
        ArrayList<compRecommendation>comprec= farmdb.getSimilarRecommendations(farm,dalist);
        ArrayList<compProblems>compProb= farmdb.getSimilarProblems(farm,dalist2);
        
    //Recommendations list
         fixedRecDB frb = new fixedRecDB();
       ArrayList<Recommendation> fct = new ArrayList<Recommendation>();
       fct = frb.viewRecList();
       
       
        //auto gen problist -(get similar problems)
          ArrayList<compProblems> autoprob=new ArrayList<compProblems>();
          autoprob=farmdb.getSimilarProblems(farm,dalist3);
          
          
       //Problems List
         ProblemsDB prb= new ProblemsDB();
         ArrayList<Problems> pct = new ArrayList<Problems>();
         pct= prb.viewAllProblems();
       
          if(!autoprob.isEmpty()){
            pct=prb.removeSelectedProblems(pct,autoprob);  
          }
         

         
          
          
       //remove from all list 
          
          
         
         session.setAttribute("flist",list);
         session.setAttribute("farm",farm);
         session.setAttribute("comprec",comprec);
         session.setAttribute("comprob",compProb);
         session.setAttribute("darecs",fct);
         session.setAttribute("daprobs",pct);
         session.setAttribute("autoprob",autoprob);
      
         
         
        
         
        RequestDispatcher rd = context.getRequestDispatcher("/viewComparison.jsp");

        rd.forward(request, response);
   
    }
}
