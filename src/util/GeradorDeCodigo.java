package util;

public class GeradorDeCodigo {

        private static int ID = 1;

        public static int getProximaMatricula() {
            return ID++;
        }

}
