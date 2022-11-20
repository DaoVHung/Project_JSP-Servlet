package ra.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.Model.Entity.Catalog;
import ra.Model.Service.CatalogService;
import ra.Model.ServiceImp.CatalogServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService<Catalog,String> catalogService = new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action!=null&&action.equals("Update")) {
            Integer catalogID = Integer.parseInt(request.getParameter("catalogID"));
            Catalog cataUpdate = catalogService.getById(catalogID);
            request.setAttribute("cataUpdate", cataUpdate);
            request.getRequestDispatcher("View/Catalog/catalogUpdate.jsp").forward(request,response);
        }else if(action!=null&&action.equals("GetById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Catalog catUpdate = catalogService.getById(catalogId);
            String json = GSON.toJson(catUpdate);
            response.setStatus(200);
            response.setHeader("Content-Type","application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }
         getAllProduct(request,response);
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> catalogList = catalogService.getAll();
        request.setAttribute("catalogList", catalogList);
        request.getRequestDispatcher("category.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action != null && action.equals("Create")) {
            Catalog c = new Catalog();
            c.setCatalogName(request.getParameter("catalogName"));
            c.setTitle(request.getParameter("title"));
            c.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.save(c);
            if (result) {
                getAllProduct(request, response);

            } else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);

            }
        }else if(action!=null && action.equals("Search")){
            String catalogName = request.getParameter("catalogName");
            List<Catalog> catalogList = catalogService.searchProByName(catalogName);
            request.setAttribute("catalogList", catalogList);
            request.getRequestDispatcher("category.jsp").forward(request,response);
        }else if(action!=null && action.equals("Update")){
            Catalog c = new Catalog();
            c.setCatalogID(Integer.parseInt(request.getParameter("catalogID")));
            c.setCatalogName(request.getParameter("catalogName"));
            c.setTitle(request.getParameter("title"));
            c.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.update(c);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);
            }
        }else if (action!=null && action.equals("Delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catCatalogId"));
            boolean result = catalogService.delete(catalogId);
            if (result) {
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("View/Error/erroe.jsp").forward(request, response);
            }
        }
    }
}
