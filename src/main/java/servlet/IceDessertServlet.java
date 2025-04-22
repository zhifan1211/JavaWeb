package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;

@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet {

    private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deleteParam = req.getParameter("delete");

        if (deleteParam != null) {
            try {
                int indexToDelete = Integer.parseInt(deleteParam);
                if (indexToDelete >= 0 && indexToDelete < iceOrders.size()) {
                    iceOrders.remove(indexToDelete);
                }
            } catch (NumberFormatException e) {
                // ignore or log error
            }

            // 刪除後仍然顯示結果頁
            req.setAttribute("iceOrders", iceOrders);
            req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp").forward(req, resp);
            return;
        }

        // 沒有 delete 參數就回到表單頁
        req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String mainDishName = req.getParameter("mainDish");
        String[] toppingArray = req.getParameterValues("toppings");

        // 建立 IceOrder
        IceOrder iceOrder = new IceOrder(mainDishName, toppingArray);

        // 加入到訂單集合中
        iceOrders.add(iceOrder);

        // 傳遞給 JSP 顯示結果頁
        req.setAttribute("iceOrders", iceOrders);
        req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp").forward(req, resp);
    }
}

