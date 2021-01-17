package com.github.marwin1991.intelijgitlabplugin;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.impl.ActionToolbarImpl;
import com.intellij.util.ui.JBEmptyBorder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GitLabToolWindowToolbar extends JPanel {

    public static final String ACTION_GROUP_ID = "GitLabToolWindowToolbar";

    public GitLabToolWindowToolbar() {
        super(new BorderLayout());
        final ActionToolbar toolbar = createToolbarFromGroupId(ACTION_GROUP_ID);
        this.add(toolbar.getComponent());
    }

    @NotNull
    public static ActionToolbar createToolbarFromGroupId(@NotNull String groupId) {
        final ActionManager actionManager = ActionManager.getInstance();

        if (!actionManager.isGroup(groupId)) {
            throw new IllegalStateException(groupId + " should have been a group");
        }

        DefaultActionGroup toolbarGroup = new DefaultActionGroup();

        final DefaultActionGroup group = (DefaultActionGroup) actionManager.getAction(groupId);
        AnAction[] children = group.getChildren(null);

        //Create new group of actions without actions starting by SUB_ACTIONS_PREFIX.
        String[] actionIds = actionManager.getActionIds("GitLabToolWindowToolbar");
        ArrayList<AnAction> exclusions = new ArrayList<>();
        for (String actionId : actionIds) {
            exclusions.add(actionManager.getAction(actionId));
        }
        for (AnAction child : children) {
            if (!exclusions.contains(child)) {
                toolbarGroup.addAction(child);
            }
        }

        final ActionToolbarImpl editorToolbar =
                ((ActionToolbarImpl) actionManager.createActionToolbar("unknown", toolbarGroup, true));
        editorToolbar.setOpaque(false);
        editorToolbar.setBorder(new JBEmptyBorder(0, 2, 0, 2));

        return editorToolbar;
    }

}