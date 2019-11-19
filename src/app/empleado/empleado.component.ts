import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent implements OnInit {

  empleadosList: Empleado[];
  
  constructor(private empService: EmpleadoService) { }

  deleteEmpleado(dni: string) {
    this.empService.deleteEmpleado(dni).subscribe( () => window.location.reload());
  }

  
  ngOnInit() {
    this.empService.findAll().subscribe(data => {
      this.empleadosList = data;
    })
  }
  

}
