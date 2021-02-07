package jp.co.bhopari.timetransform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.bhopari.timetransform.services.TimeTransformService;

//時間表記変換Webアプリコントローラー

@Controller
public class TimeTransformController {

	//TimeTransformService型のtimeTransformServiceを定義
	@Autowired
	private TimeTransformService timeTransformService;

	private static final String SERVLET_NAME = "/timetransform";

	//時間表記変換結果
	String timeTransformResult;

	//入力値hour,minuteを格納する変数
	int hour = 0;
	int minute = 0;

	//初期画面
	@RequestMapping(path = SERVLET_NAME)
	public String showInitialScreen(){
		return "TimeTransform";
	}


	@GetMapping(path = SERVLET_NAME, params = "name=do")
	public String transform(@ModelAttribute("hour")String inputHour, @ModelAttribute("minute")String inputMinute, Model model) {

		//入力値hour入力チェック
		//入力値hourを整数型にする
		if (inputHour.equals("")) {
			//未入力の場合エラーメッセージをViewに返す
			model.addAttribute("errorMessage", "エラー：左側のボックスに値を入力してください。");
			return "TimeTransform";
		}

		//入力値hour整数値チェック
		try {
			hour = Integer.parseInt(inputHour);
		} catch (NumberFormatException e) {
			model.addAttribute("errorMessage", "エラー：左側のボックスに整数を入力してください。");
			return "TimeTransform";
		}

		//入力値minuteを整数型にする
		minute = Integer.parseInt(inputMinute);

		//主処理
		//時間表記変換呼び出し
		try {
			model.addAttribute(timeTransformResult, timeTransformService.transformTime(hour,minute));
		} catch (IllegalArgumentException e) {
			model.addAttribute("errorMessage", "エラー：左側のボックスに0から99までの値を入力してください。");
		}

			return "TimeTransform";
	}
}
