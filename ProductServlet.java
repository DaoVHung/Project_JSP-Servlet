package ra.Controller;

import ra.Model.Entity.Catalog;
import ra.Model.Entity.Product;
import ra.Model.Service.CatalogService;
import ra.Model.Service.ProductService;
import ra.Model.ServiceImp.CatalogServiceImp;
import ra.Model.ServiceImp.ProductVerviceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class ProductServlet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductVerviceImp();
    private CatalogService<Catalog, String> catalogService = new CatalogServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("Update")) {
            List<Catalog> listcat = catalogService.getAll();
            request.setAttribute("listcat", listcat);
            Integer productUpdate = Integer.parseInt(request.getParameter("productID"));
            Product productUp = productService.getById(productUpdate);
            request.setAttribute("productUpdate", productUp);
            request.getRequestDispatcher("View/Product/ProductUpdate.jsp").forward(request, response);

        } else if (action != null && action.equals("newProduct")) {
            List<Catalog> listcat = catalogService.getAll();
            request.setAttribute("listcat", listcat);
            request.getRequestDispatcher("View/Product/productCreate.jsp").forward(request, response);
        } else if (action != null && action.equals("GetByID")) {
            Integer productID = Integer.parseInt(request.getParameter("productID"));
            Product product = productService.getById(productID);
            request.setAttribute("proDetail", product);
            request.getRequestDispatcher("View/Product/productDetail.jsp").forward(request, response);
        } else {
            getAllProduct(request, response);
        }
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Create")) {
            Product productNew = new Product();
            String pathFolderImage = "D:/MD-3/ProjectMD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            Product product = new Product();
            product.setProductName(request.getParameter("productName"));
            product.setCatalogID(request.getParameter("catalogID"));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            product.setTitle(request.getParameter("title"));
            product.setDescription(request.getParameter("descriptions"));
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImg")) {
                    String productImgName = part.getSubmittedFileName();
                    product.setProductImg(productImgName);
                    part.write(pathFolderImage + File.separator + productImgName);
                } else if (part.getName().equals("subImg")) {
                    String subImgName = part.getSubmittedFileName();
                    product.getListImgLinks().add(subImgName);
                    InputStream fileContent = part.getInputStream();
                    part.write(pathFolderImage + File.separator + subImgName);
                }
            }
            boolean result = productService.save(product);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);

            }
        } else if (action != null && action.equals("Update")) {
            Product productNew = new Product();
            String pathFolderImage = "D:/MD-3/ProjectMD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            Product product = new Product();
            product.setProductID(Integer.parseInt(request.getParameter("productID")));
            product.setProductName(request.getParameter("productName"));
            product.setCatalogID(request.getParameter("catalogID"));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            product.setTitle(request.getParameter("title"));
            product.setDescription(request.getParameter("descriptions"));
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImg")) {
                    String productImgName = part.getSubmittedFileName();
                    product.setProductImg(productImgName);
                    part.write(pathFolderImage + File.separator + productImgName);
                } else if (part.getName().equals("subImg")) {
                    String subImgName = part.getSubmittedFileName();
                    product.getListImgLinks().add(subImgName);
                    InputStream fileContent = part.getInputStream();
                    part.write(pathFolderImage + File.separator + subImgName);
                }
            }
            boolean result = productService.update(product);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("Search")) {
            String productName = request.getParameter("productName");
            List<Product> productList = productService.searchProByName(productName);
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            int productId = Integer.parseInt(request.getParameter("proProductId"));
            boolean result = productService.delete(productId);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);
            }
        }
    }
}
