package com.example.demo.app;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {

	private final JdbcTemplate jdbcTemplate;

	public SampleController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/test")
	public String test(Model model) {
		String sql = "SELECT id, name, email "
				+ "FROM inquiry WHERE id = 1";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);

		//演習1-1 sql2の変数名でid2のお問い合わせを取得するSQL文を定義する
		String sql2 = "SELECT id, name, email "
				+ "FROM inquiry WHERE id = 2";
		//演習1-2 Map<String,Object＞型のmap2の変数名にqueryForMapでsql2を渡した結果を格納する
		Map<String, Object> map2 = jdbcTemplate.queryForMap(sql2);
		//演習1-3 model.addAttributeでname2,email2という名前でmap2のname,emailを設定する
		model.addAttribute("name2", map2.get("name"));
		model.addAttribute("email2", map2.get("email"));

		model.addAttribute("name", map.get("name"));
		model.addAttribute("email", map.get("email"));
		model.addAttribute("title", "Inquiry Form");
		return "test";
	}

}