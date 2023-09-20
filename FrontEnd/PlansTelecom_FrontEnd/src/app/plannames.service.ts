import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SimPlans } from './sim-plans/SimPlans';

@Injectable({
  providedIn: 'root'
})
export class PlannamesService {

  allList="http://localhost:8085/api/v1/getplannames";
  itemsById="http://localhost:8085/api/v1/getplannames";
  constructor(private http:HttpClient) {}
  getCategory(simplans:any):Observable<SimPlans[]>{
    return this.http.get<SimPlans[]>(`${this.allList}/${simplans}`);
  }
  getCategoryById(planId:any):Observable<SimPlans>{
    return this.http.get<SimPlans>(`${this.itemsById}/${planId}`)
  }
}
