package Peaksoft.Servise;


import Peaksoft.Interface.GrouphInterface;
import Peaksoft.Model.Group;
import Peaksoft.Model.Peaksoft;

import java.util.Arrays;


public class GroupServes implements GrouphInterface {
    private Peaksoft peaksoft;

    public GroupServes(Peaksoft peaksoft) {
        this.peaksoft = peaksoft;
    }

    @Override
    public Group[] getAllGroup() {
        return peaksoft.getGroups();


    }


    @Override
    public Group getGroupByName(String name) {
        for (int i = 0; i < peaksoft.getGroups().length; i++) {
            if (peaksoft.getGroups()[i].getName().equals(name)) {
                System.out.println(Arrays.toString(peaksoft.getGroups()));
            }

            return peaksoft.getGroups()[i];
        }
        return null;
    }

    @Override
    public void deleteGroup(int id) {
        Group[] groups = peaksoft.getGroups();
        Group[] updatedGroups = new Group[groups.length - 1];
        int index = 0;
        for (Group group1 : groups) {
            if (group1.getId() != id) {
                updatedGroups[index] = group1;
                index++;
            }
        }
        peaksoft.setGroups(updatedGroups);
        System.out.println(Arrays.toString(updatedGroups));
    }

    @Override
    public Group[] createGroup(Group group) {
        boolean x = true;
        Group[] groups = peaksoft.getGroups();
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].getName().equals(group.getName())) {
                x = false;
                System.out.println("Данный студент уже есть в базе данных");
            }
            break;
        }
        if (x) {
            Group[] groups1;
            groups1 = Arrays.copyOf(groups, groups.length - 1);
            groups1[groups1.length - 1] = group;
            peaksoft.setGroups(groups1);
            System.out.println(Arrays.toString(groups1));
        }
        return groups;
    }



    @Override
    public void updateById(int id, Group group) {
        Group[] groups = peaksoft.getGroups();
        for (int i = 0; i < groups.length; i++) {
        if(groups[i].getId()==id){
            groups[i].setId(id);
            groups[i].setName(groups[i].getName());
            groups[i].setStudents(group.getStudents());
            groups[i].setCount(group.getCount());
            System.out.println(groups[i]);
        }
        }
    }

    @Override
    public Group[] findById(int id) {
        Group[] groups = peaksoft.getGroups();
        for (int i = 0; i <groups.length; i++) {
 if(groups[i].getId()==id){
     System.out.println(groups[i]);
 }else{
     System.out.println("in base haven't group with this id");
 }
        }
        return groups;
    }
}