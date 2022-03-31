package com.mypractice.bo;


import lombok.Data;

/*@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor*/

@Data
public class EmployeeBO {
  private int empNo;
  private String ename;
 private  String desg;
  private int salary;
}
