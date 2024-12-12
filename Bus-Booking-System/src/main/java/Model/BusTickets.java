package Model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class BusTickets {

    private  String name;
    private String mobile;
    private int seats;
    private String date;


}
