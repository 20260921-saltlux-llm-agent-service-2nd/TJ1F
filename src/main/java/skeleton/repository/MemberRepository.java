package skeleton.repository;

import skeleton.common.JDBCTemplate;
import skeleton.model.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 회원 정보 JDBC 처리 담당.
 */
public class MemberRepository {

    private static final String QUERY_FILE =
            "src/main/java/skeleton/mapper/member-query.xml";

    private final Properties prop = new Properties();

    public MemberRepository() {
        try (FileInputStream inputStream = new FileInputStream(QUERY_FILE)) {
            prop.loadFromXML(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("회원 SQL 파일을 읽지 못했습니다.", e);
        }
    }

    /*
     * 문제 REPOSITORY-1. 회원가입
     *
     * Member의 name, age, phone을 member_tbl에 INSERT한다.
     * member_id는 AUTO_INCREMENT이므로 INSERT 컬럼에서 제외한다.
     * JdbcConnectionFactory로 Connection을 얻고 PreparedStatement를 사용한다.
     * executeUpdate() 결과가 1이면 true, 0이면 false를 반환한다.
     * SQL은 prop.getProperty("insertMember")로 조회한다.
     * JDBC 자원은 try-with-resources로 닫고 SQLException은 원인을 포함한
     * IllegalStateException으로 변환한다.
     */
    public boolean save(Member member) {
        // TODO: XML의 SQL을 사용해 JDBC로 신규 회원을 저장하세요.

        int result = 0;
        String query = prop.getProperty("insertMember");

        try (Connection con = JDBCTemplate.getConnection();
             PreparedStatement pstm = con.prepareStatement(query);
        ) {


            pstm.setString(1, "name");
            pstm.setString(2, "age");
            pstm.setString(3, "phone");

            result = pstm.executeUpdate();
            if (result == 1) {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }

    /*
     * 문제 REPOSITORY-2. 휴대폰 번호로 회원 조회
     *
     * member_tbl 테이블에서 phone이 매개변수와 일치하는 회원 한 명을 조회한다.
     * JdbcConnectionFactory로 Connection을 얻고 PreparedStatement를 사용한다.
     * ResultSet에 조회 결과가 있으면 Member 객체로 변환하여 반환한다.
     * 조회 결과가 없으면 null을 반환한다.
     * Connection, PreparedStatement, ResultSet은 try-with-resources로 닫는다.
     * SQLException은 메시지와 원인을 포함한 IllegalStateException으로 변환한다.
     * SQL은 prop.getProperty("selectMemberByPhone")로 조회한다.
     */
    public Member findByPhone(String phone) {
        Connection conn = JDBCTemplate.getConnection();
        Member result = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectMemberByPhone"));
            pstmt.setString(1, phone);
            ResultSet rSet = pstmt.executeQuery();

            if (rSet.next()) {
                result = new Member(
                        rSet.getInt("member_id"),
                        rSet.getString("name"),
                        rSet.getInt("age"),
                        rSet.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * 문제 REPOSITORY-3. 회원 탈퇴
     *
     * member_id가 일치하는 회원을 member_tbl에서 DELETE한다.
     * 회원의 구독 기록은 외래 키의 ON DELETE CASCADE 제약 조건으로 함께 삭제된다.
     * PreparedStatement를 사용하고 executeUpdate() 결과가 1이면 true를 반환한다.
     * JDBC 자원은 try-with-resources로 닫고 SQLException은 원인을 포함한
     * IllegalStateException으로 변환한다.
     * SQL은 prop.getProperty("deleteMemberById")로 조회한다.
     */
    public boolean deleteById(int memberId) {
        // TODO: XML의 SQL을 사용해 로그인 회원을 삭제하세요.
        return false;
    }
}
