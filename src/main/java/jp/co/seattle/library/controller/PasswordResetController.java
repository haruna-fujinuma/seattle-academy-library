import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.seattle.library.dto.UserInfo;
import jp.co.seattle.library.service.UsersService;

@Controller // APIの入り口
public class PasswordResetController {
	final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/passwordReset", method = RequestMethod.GET) // value＝actionで指定したパラメータ
	public String createAccount(Model model) {
		return "login";
	}

	{
		if (password.length() >= 8 && password.matches("[A-Za-z0-9]+")) {
			if (password.equals(password2)) {
				UserInfo userInfo = new UserInfo();
				userInfo.setEmail(email);
				userInfo.setPassword(password);
				usersService.registUser(userInfo);
				return "login";
			} else {
				model.addAttribute("errorMessage", "パスワードが一致しません。");
				return "passwordReset";
			}
		} else {
			model.addAttribute("errorMessage", "パスワードは8桁以上の半角英数字設定してください。");
			return "passwordReset";
		}

	}
}
