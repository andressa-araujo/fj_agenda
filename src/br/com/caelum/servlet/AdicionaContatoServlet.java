package br.com.caelum.servlet;

import java.io.*;
import java.io.PrintWriter;
import java.text.*;
import java.util.Calendar;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.util.DataFormatada;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import java.io.IOException;


@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		//Calendar dataNascimento = null;
		
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(DataFormatada.DataFormata(dataEmTexto));;
		
		
		ContatoDao dao = null;
		try {
			dao = new ContatoDao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		dao.adiciona(contato);
	
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/contato-adicionado.jsp");
				rd.forward(request,response);
	}
}
