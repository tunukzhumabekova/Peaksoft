package Peaksoft.Interface;

import Peaksoft.Model.Mentor;

public interface MentorIntarface {
        Mentor[] getAllMentor();
        void getMentoryByemail(String email);
        void deleteMentorById(int id);
        Mentor[] createMentor(Mentor mentor);
        Mentor[] updateById(int id, Mentor mentor);
        void findById(int id);
    }

