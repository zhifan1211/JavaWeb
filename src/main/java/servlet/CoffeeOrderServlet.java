package servlet;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeOrder;

@WebServlet("/coffeeOrder")
public class CoffeeOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 編碼設定
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 2. 接收參數
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");
		
		// 3. 判斷參數
		if(type == null||size == null||sugar==null) {
			resp.getWriter().print("參數輸入不正確");
			return;
		} 
		// 4. 進行商業邏輯
		CoffeeOrder coffeeOrder= new CoffeeOrder(type,size,sugar);
		//resp.getWriter().print(coffeeOrder.getInfo());
		// 5. 建立分派器(model 1)
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeeOrder", coffeeOrder);
		rd.forward(req, resp);
	}
}
