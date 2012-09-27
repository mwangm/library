package com.twu28.biblioteca.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static Map<Integer, IAction> actionMap = initialActionMap();

    private static Map<Integer, IAction> initialActionMap() {
        Map<Integer, IAction> actionMap = new HashMap<Integer, IAction>();
        addActionToMap(actionMap, ShowBooksAction.class);
        addActionToMap(actionMap, ReserveBookAction.class);
        addActionToMap(actionMap, CheckDetailAction.class);
        addActionToMap(actionMap, ShowMoviesAction.class);
        addActionToMap(actionMap, LoginAction.class);
        addActionToMap(actionMap, ExitAction.class);
        return actionMap;
    }

    private static void addActionToMap(Map<Integer, IAction> actionMap, Class actionClass) {
        IAction action = null;
        try {
            action = (IAction) actionClass.newInstance();
            actionMap.put(action.getActionCode(), action);
        } catch (Exception e) {
            System.out.println("reflection error");
        }
    }

    public static IAction createAction(int selectedOption) {
        if (actionMap.containsKey(selectedOption))
            return actionMap.get(selectedOption);

        return new NotValidAction();
    }

    public static String getActionList() {
        StringBuilder actionList = new StringBuilder();

        for (IAction action : actionMap.values()) {
          actionList.append(action.getActionCode()).append(":").append(action.getDescription()).append("\n");
        }

        return actionList.toString();
    }
}
