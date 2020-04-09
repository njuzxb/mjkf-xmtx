package com.xmtx.user.VO;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignSuccessVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String name;
    private String token;
    private Integer is_enterprise;


}
