import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpleadoService } from '../empleado.service';
import { Empleado } from '../empleado';

@Component({
  selector: 'app-empleado-form',
  templateUrl: './empleado-form.component.html',
  styleUrls: ['./empleado-form.component.css']
})
export class EmpleadoFormComponent implements OnInit {
  
  empleado: Empleado;
 
  constructor( private router: Router, private empService: EmpleadoService) {
    this.empleado = new Empleado();
  }
 
  onSubmit() {
    this.empService.create(this.empleado).subscribe(() => this.irEmpleadoList());
  }
 
  irEmpleadoList() {
    this.router.navigate(['/empleados']);
  }
  ngOnInit() {
  }

}
