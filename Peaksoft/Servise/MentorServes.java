package Peaksoft.Servise;

    import Peaksoft.Interface.MentorIntarface;
    import Peaksoft.Model.Mentor;
    import Peaksoft.Model.Peaksoft;

    import java.util.Arrays;

    public class MentorServes implements MentorIntarface {
        private Peaksoft peaksoft;
public MentorServes(Peaksoft peaksoft){
    this.peaksoft=peaksoft;
}

        @Override
        public Mentor[] getAllMentor() {
            return peaksoft.getMentors();
        }

        @Override
        public void getMentoryByemail(String email) {
    Mentor []mentors= peaksoft.getMentors();
            for (Mentor m:mentors) {
                if (m.getEmail().equals(email)){
                    System.out.println(m);
            }
            }
}

        @Override
        public void deleteMentorById(int id) {
            Mentor[] mentors = peaksoft.getMentors();
            Mentor[] updatedMentors = new Mentor[mentors.length - 1];
            int index = 0;

            for (Mentor mentor : mentors) {
                if (mentor.getId() != id) {
                    updatedMentors[index] = mentor;
                    index++;
                }
            }

            peaksoft.setMentors(updatedMentors);

            System.out.println(" Студент с ID " + id + " удален ");
            System.out.println("Новый массив после удаления: " + Arrays.toString(updatedMentors));
        }

        @Override
        public Mentor[] createMentor(Mentor mentor) {
            boolean x = true;
            Mentor[] mentors = peaksoft.getMentors();
            for (int i = 0; i < mentors.length; i++) {
                if (mentors[i].getName().equals(mentor.getName())) {
                    x = false;
                    System.out.println("Данный ментор уже есть в базе данных");
                }
                break;
            }
            if (x) {
                Mentor[] mentors1;
                mentors1 = Arrays.copyOf(mentors, mentors.length - 1);
                mentors1[mentors1.length - 1] = mentor;
                peaksoft.setMentors(mentors1);
                System.out.println(Arrays.toString(mentors1));
            }
            return mentors;
        }

        @Override
        public Mentor[] updateById(int id, Mentor mentor) {
            Mentor[] mentors = peaksoft.getMentors();
            for (int i = 0; i < mentors.length; i++) {
                if(mentors[i].getId()==id){
                    mentors[i].setId(id);
                    mentors[i].setName(mentors[i].getName());
mentors[i].setEmail(mentors[i].getEmail());
mentors[i].setGender(mentors[i].getGender());
mentors[i].setGroup(mentors[i].getGroup());
                    System.out.println(mentors[i]);
                }

            }
            return mentors;
        }

        @Override
        public void findById(int id) {
            Mentor[] mentors = peaksoft.getMentors();
            for (int i = 0; i < mentors.length; i++) {
                if (mentors[i].getId() == id) {
                    System.out.println(mentors[i]);
                }
            }
        }
    }



