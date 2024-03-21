public class TaiKhoanEnumExample {

    public enum TaiKhoan {
        VTT("Tai khoan ViettelPay"),
        MM("Tien di dong"),
        // Thêm các giá trị enum khác nếu cần
        ;

        private final String des;

        TaiKhoan(String description) {
            this.des = description;
        }

//        public String getDescription() {
//            return description;
//        }

        // Phương thức tĩnh để lấy giá trị enum từ một chuỗi
        public static TaiKhoan fromString(String text) {
            for (TaiKhoan tk : TaiKhoan.values()) {
                if (tk.name().equalsIgnoreCase(text)) {
                    return tk;
                }
            }
            return null; // hoặc throw IllegalArgumentException
        }
    }

    public static void main(String[] args) {
        String tkString = "MM";
        TaiKhoan tk = TaiKhoan.fromString(tkString);
        if (tk != null) {
            System.out.println(tk); // Output: Tai khoan ViettelPay
        } else {
            System.out.println("Không tìm thấy tài khoản phù hợp");
        }
    }
}