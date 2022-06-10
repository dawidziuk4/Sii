package com.example.sii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PrelectionsInfo {

   private int numOfParticipants;
   private int prelectionNr;
   private String info = "Prelection nr #"+prelectionNr+" is in "+numOfParticipants/4+"% occupied.";

}
