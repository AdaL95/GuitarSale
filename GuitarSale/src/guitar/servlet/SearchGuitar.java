  package guitar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    
		String type=request.getParameter("type");
		String price=request.getParameter("price");
		String builder=request.getParameter("builder");
		String backwood=request.getParameter("backwood");
		String topwood=request.getParameter("topwood");
		
	
			
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		SQLException ex=null;
		
		String a=null;
		if(!type.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE type=?";
		}
		if(!price.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE price=?";
		}
		if(!builder.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE builder=?";
		}
		if(!backwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE backwood=?";
			
		}
		if(!topwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE topwood=?";
		}
		try{
			Statement dataSource = null;
			conn=dataSource.getConnection();
			statement=conn.prepareStatement(a);
			
			statement.setString(1, SearchGuitar.gettype());
			result=statement.executeQuery();
			while (result.next()){
			}
			}catch (SQLException e){
				ex=e;
			}finally{				
				if (statement!= null){
					try{
						statement.close();
					}
					catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
					
				}
				if (conn!=null){
					try{
						conn.close();
					}
					catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
				
			}
		request.getRequestDispatcher("result.jsp").forward(request,response);
	
}

	

	private static String gettype() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
