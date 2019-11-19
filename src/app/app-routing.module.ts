import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpleadoComponent } from './empleado/empleado.component';
import { EmpleadoFormComponent } from './empleado-form/empleado-form.component';
import { UpdateEmpleadoComponent } from './update-empleado/update-empleado.component';
import { NominaComponent } from './nomina/nomina.component';


const routes: Routes = [
  {path: 'empleados', component: EmpleadoComponent},
  {path: 'createEmpleado', component: EmpleadoFormComponent},
  {path: 'update/:dni', component: UpdateEmpleadoComponent},
  {path: 'nominas', component: NominaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
