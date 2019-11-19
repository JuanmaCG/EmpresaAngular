import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpleadoComponent } from './empleado/empleado.component';
import { NominaComponent } from './nomina/nomina.component';
import { EmpleadoFormComponent } from './empleado-form/empleado-form.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateEmpleadoComponent } from './update-empleado/update-empleado.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpleadoComponent,
    NominaComponent,
    EmpleadoFormComponent,
    UpdateEmpleadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
