package com.keduit.controller;

import com.keduit.controller.action.Action;
import com.keduit.controller.action.BoardCheckPassAction;
import com.keduit.controller.action.BoardCheckPassFormAction;
import com.keduit.controller.action.BoardDeleteAction;
import com.keduit.controller.action.BoardListAction;
import com.keduit.controller.action.BoardUpateAction;
import com.keduit.controller.action.BoardUpdateFormAction;
import com.keduit.controller.action.BoardViewAction;
import com.keduit.controller.action.BoardWriteAction;
import com.keduit.controller.action.BoardWriteFormAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {

	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		switch (command) {

		case "board_list": {
			action = new BoardListAction();
			break;
		}
		case "board_write_form": {
			action = new BoardWriteFormAction();
			break;
		}
		case "board_write": {
			action = new BoardWriteAction();
			break;
		}
		case "board_view": {
			action = new BoardViewAction();
			break;
		}
		case "board_check_pass_form": {
			action = new BoardCheckPassFormAction();
			break;
		}
		case "board_check_pass": {
			action = new BoardCheckPassAction();
			break;
		}
		case "board_delete": {
			action = new BoardDeleteAction();
			break;
		}
		case "board_update_form": {
			action = new BoardUpdateFormAction();
			break;
		}
		case "board_update": {
			action = new BoardUpateAction();
		}
		}

		return action;

	}
}
