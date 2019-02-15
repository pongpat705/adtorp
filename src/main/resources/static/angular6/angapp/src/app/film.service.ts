import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Film } from './film';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({ providedIn: 'root' })
export class FilmService {

  private filmesUrl = 'http://localhost:8080/api/allFilmsByRatingViaReposNamedMethod?page=0&rating=G&size=20';  // URL to web api

  constructor(
    private http: HttpClient) { }

  /** GET filmes from the server */
  getFilmes (): Observable<Film[]> {
    return this.http.get<Film[]>(this.filmesUrl)
      .pipe(
        tap(_ => console.log('fetched filmes')),
        catchError(this.handleError('getFilmes', []))
      );
  }

  /** GET film by id. Return `undefined` when id not found */
  getFilmNo404<Data>(id: number): Observable<Film> {
    const url = `${this.filmesUrl}/?id=${id}`;
    return this.http.get<Film[]>(url)
      .pipe(
        map(filmes => filmes[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          // this.log(`${outcome} film id=${id}`);
        }),
        catchError(this.handleError<Film>(`getFilm id=${id}`))
      );
  }


  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      // this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
