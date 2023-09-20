import { Component } from '@angular/core';
import { PlannamesService } from '../plannames.service';
import { SimPlans } from './SimPlans';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sim-plans',
  templateUrl: './sim-plans.component.html',
  styleUrls: ['./sim-plans.component.css']
})
export class SimPlansComponent {
  // aObj:Category;
  cList: SimPlans[] = [];
  selectedCategory: SimPlans | undefined;

  constructor(private categoryService: PlannamesService,private router:Router) {
    // this.aObj=new Admin();
   }

  ngOnInit() {            
    this.getCategories();
    this.getCategories1();
    this.getCategories2();
  }

  getCategories(){
    const category:String="Singtel-Basic";
    this.categoryService.getCategory(category).subscribe(
      data=>{
        this.cList=data;

      },
      err=>{
        console.log(err);
      }
    )
  }
  getCategories1(){
    const category:String="Singtel-Medium";
    this.categoryService.getCategory(category).subscribe(
      data=>{
        this.cList=data;
      },err=>{
        console.log(err)
      }
    )
  }
  getCategories2(){
    const category:String="Singtel-High";
    this.categoryService.getCategory(category).subscribe(
      data=>{
        this.cList=data;
      },
      err=>{
        console.log(err);
      }
    )
  }

  selectCategory(data: SimPlans) {
    this.selectedCategory = data;
    console.log(SimPlans)
  }
  // viewProduct(category: any){
  //   alert(category)
  //   localStorage.setItem('selectedProduct', category);
  //   this.router.navigate(['/viewproduct']);
  //   console.log("it is an id"+category)
  // }
  viewProduct(simplans:any){
    localStorage.setItem("selectedProduct",simplans)
    console.log(simplans)
    this.router.navigate(['viewproduct'])
  }

  
  isBouncing: boolean = false;

  startBounceAnimation() {
    this.isBouncing = true;
    setTimeout(() => {
      this.isBouncing = false;
    }, 500);
  }
  // addTOCart(pro:any){
  //   alert("Hello")
  //   this.addcart.addtoCart(this.aObj).subscribe(
      
  //     data=>{
        
  //       console.log(data)
  //     },
      
  //   )
  // }
}
