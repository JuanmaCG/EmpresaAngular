import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpleadoService } from '../empleado.service';
import { Empleado } from '../empleado';

@Component({
  selector: 'app-update-empleado',
  templateUrl: './update-empleado.component.html',
  styleUrls: ['./update-empleado.component.css']
})
export class UpdateEmpleadoComponent implements OnInit {

  dni: string;
  empleado: Empleado;

  constructor(private route: ActivatedRoute,private router: Router,
    private empService: EmpleadoService) { }

  ngOnInit() {
    this.empleado = new Empleado();

    this.dni = this.route.snapshot.params['dni'];
    
    this.empService.findByDni(this.dni)
      .subscribe(data => {
        this.empleado = data;
      }, error => console.log(error));
  }

  updateEmpleado() {
    this.empService.updateEmpleado(this.empleado, this.dni)
      .subscribe(data => console.log(data), error => console.log(error));
    this.empleado = new Empleado();
    this.gotoList();
  }

  onSubmit() {
    this.updateEmpleado();    
  }

  gotoList() {
    this.router.navigate(['/empleados']).then(() => window.location.reload());
  }
}
