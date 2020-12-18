package data;

import java.util.ArrayList;

public class CourseData {

    private String[] courseNames = {"Image One", "Image Two", "Image Three",
            "Image Four", "Image Five", "Image Six", "Image Seven"};

    public ArrayList<Course> courseList(){
        ArrayList<Course> list = new ArrayList<>();

        for (int i = 0; i< courseNames.length; i++){
            Course course = new Course(courseNames[i],courseNames[i].replace(" ",
                    "").toLowerCase());

            list.add(course);
        }

        return list;

    }

}
