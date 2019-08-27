package net.devstudy.resume.controller;


import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//@WebServlet("/profile")
public class ProfileController  {

    @Autowired
    private NameService nameService;



//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String param = req.getParameter("name");
//        if (param !=null){
//            req.setAttribute("name",nameService.convertName(param));
//        }
//        req.getRequestDispatcher("/WEB-INF/JSP/profile.jsp").forward(req,resp);
//    }
}
