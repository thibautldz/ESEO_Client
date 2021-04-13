package com.javaBeans;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
	String Code_commune_INSEE;
	String Nom_commune;
	String Code_postal;
	String Libelle_acheminement;
	String Ligne_5;
	String Latitude;
	String Longitude;
	
	public double calculerDistance(Ville ville2) {
        
        double distance = 0;
        
        double longitudeVille1 = Double.valueOf(this.getLongitude());
        double longitudeVille2 = Double.valueOf(ville2.getLongitude());
        
        double latitudeVille1 = Double.valueOf(this.getLatitude());
        double latitudeVille2 = Double.valueOf(ville2.getLatitude());
        
        
        double first = (longitudeVille2 - longitudeVille1) * Math.cos((latitudeVille2 + latitudeVille1)/2);
        
        double second = latitudeVille2 - latitudeVille1;
        
        double third = Math.sqrt(Math.pow(first, 2) + Math.pow(second, 2));
        
        distance = 1.852 * 60 * third;
        
        
        return distance;
    }
}
