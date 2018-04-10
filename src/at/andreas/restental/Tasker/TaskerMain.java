package at.andreas.restental.Tasker;


import at.andreas.restental.Tasker.gui.TaskerGUI;
import at.andreas.restental.Tasker.io.TaskerXMLParser;

public class TaskerMain {

    public static void main(String args[]){
        Task tsk[] = new TaskerXMLParser(args[0]).readTasks();
        System.out.println("got " + tsk[0].getName());
        TaskerGUI test = new TaskerGUI();
        for(int i = 0; i < tsk.length; i++) {
        	test.addGUITask(tsk[i]);
        }
    }


}
