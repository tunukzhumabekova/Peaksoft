package Peaksoft.Interface;

import Peaksoft.Model.Group;

public interface GrouphInterface  {
        Group[] getAllGroup();
        Group getGroupByName(String name);
        void deleteGroup(int id);
        Group[] createGroup(Group group);
        void updateById(int id, Group group);
        Group[] findById(int id);
    }

