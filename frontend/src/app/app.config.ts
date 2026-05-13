import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { providePrimeNG } from 'primeng/config';
import Aura from '@primeuix/themes/aura';


export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    providePrimeNG({ 
        theme: {
            preset: Aura, // Isso carrega o visual base
            options: {
                darkModeSelector: false // Mantém o tema claro por enquanto
            }
        }
    })
  ]
};
