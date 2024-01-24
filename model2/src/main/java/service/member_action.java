package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface member_action {

	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
