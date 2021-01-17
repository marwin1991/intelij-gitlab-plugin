package com.github.marwin1991.intelijgitlabplugin;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.ui.SimpleToolWindowPanel;

import javax.swing.*;

public class GitLabToolWindow extends SimpleToolWindowPanel {

  public GitLabToolWindow() {
    super(true, false);

    final ActionManager actionManager = ActionManager.getInstance();
    DefaultActionGroup actionGroup = new DefaultActionGroup("ACTION_GROUP", false);

    actionGroup.add(ActionManager.getInstance().getAction("GitLabToolWindowToolbar.MergeRequests"));
    actionGroup.add(ActionManager.getInstance().getAction("GitLabToolWindowToolbar.ToDo"));

    ActionToolbar actionToolbar = actionManager.createActionToolbar("GitLabToolWindowToolbar", actionGroup, true);

    setContent(new JPanel());
    setToolbar(actionToolbar.getComponent());
  }
}
