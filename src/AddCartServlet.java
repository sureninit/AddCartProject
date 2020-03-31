
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddCartServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod = request.getParameter("add");
		
		ArrayList<String> productList;
		//System.out.println(items);
		HttpSession session = request.getSession();
		//session.setAttribute("shoppingiteam", prod);
		Object o = session.getAttribute("cart");
		if(o==null) {
			productList = new ArrayList<String>();
			productList.add(prod);
			session.setAttribute("cart",productList);
			System.out.println(productList);
		}else {
			ArrayList<String> existiteam = (ArrayList<String>)o;
			existiteam.add(prod);
			System.out.println(existiteam);
		}
		
		
	}


}
