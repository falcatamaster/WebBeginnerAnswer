package com.example.demo.app.inquiry;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * This is completed in Easy mode. If you want to practice, please delete this file.
 * イージーモードではこちらは完成させてあります。作成を練習したい場合は一度ファイルごと削除してください。
 */
public class InquiryForm{

	public InquiryForm() {}

    public InquiryForm(String name, String email, String contents) {
		super();
		this.name = name;
		this.email = email;
		this.contents = contents;
	}
    //演習1-1-1 InquiryFormにprivate int idを追加する
    private int id;

    //演習1-1-2 id,name,email,contentsのコンストラクタを追加する
    public InquiryForm(int id, String name,String email, String contents) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contents = contents;
	}

    //演習1-1-3 idのゲッター、セッターを追加する
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min = 1, max = 20, message="Please input 20 characters or less")
    private String name;

	@NotNull
    @Email(message = "Invalid E-mail Format")
    private String email;

    @NotNull
    private String contents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


}