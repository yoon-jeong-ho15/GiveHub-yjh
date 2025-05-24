package kh.GiveHub.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int memNo;
    private String memName;
    private String memId;
    private String memPwd;
    private String memAddress;
    private String memType;
    private String memGrade;
    private String memStatus;
    private String memConfirm;
    private String memEmail;
}
