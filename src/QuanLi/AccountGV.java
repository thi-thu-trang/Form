package QuanLi;

public class AccountGV {

    public class Teacher {
        private String ID;
        private String name;
        private String pass;

       // public List<SV> svList = SingletonSV.getInstance().getSvList();
        public Teacher(String ID, String name, String pass) {
            this.ID = ID;
            this.name = name;
            this.pass = pass;
        }

        public Teacher() {
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
}
