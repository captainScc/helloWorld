public class SingotonByInnerclass {
    public static class Singoton{
        private static Student student = new Student();
        private Singoton(){}
        public static Student getInstence(){
            return Singoton.student;
        }
    }
}
