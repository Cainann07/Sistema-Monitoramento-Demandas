import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TelaPrincipalComponent } from './pages/tela_principal/tela_principal.component';

@Component({
  selector: 'app-root',
  imports: [TelaPrincipalComponent, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend');
}
