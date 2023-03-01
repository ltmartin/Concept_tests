import {Component, OnInit} from '@angular/core';
import { Employee } from './employee';
import {EmployeeService} from "./employee.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public employees: Employee[] | undefined;
  public editEmployee: Employee | null | undefined;
  public deleteEmployee!: Employee;

  constructor(private employeeService : EmployeeService) {
  }

  public getEmployees() : void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      }
    ),
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
  }
  ngOnInit(): void {
    this.getEmployees();
  }

  public onOpenModal(employee: Employee | null, mode: string) : void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add'){
      button.setAttribute('data-bs-target', '#addEmployeeModal');
    }

    if (mode === 'edit'){
      this.editEmployee = employee;
      button.setAttribute('data-bs-target', '#updateEmployeeModal');
    }

    if (mode === 'delete'){
      if (employee != null)
        this.deleteEmployee = employee;
      button.setAttribute('data-bs-target', '#deleteEmployeeModal');
    }

    container?.appendChild(button);
    button.click();
  }

  public onAdd(addForm: NgForm) : void{
    document.getElementById('add-employee-form')?.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
        addForm.reset();
      }
    );
  }

  public onEdit(employee: Employee) : void{
    document.getElementById('editCloseButton')?.click();
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
      }
    );
  }

  public onDelete(employeeId: number) : void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      }
    );
  }

  public searchEmployees(key: string) : void {
    const results: Employee[] = [];
    // @ts-ignore
    for (const employee of this.employees){
      if ((employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)
      || (employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1)
      || (employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1)
      || (employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1)){
        results.push(employee);
      }
    }
    this.employees = results;

    if ((results.length === 0) || (!key)){
      this.getEmployees();
    }
  }
}
