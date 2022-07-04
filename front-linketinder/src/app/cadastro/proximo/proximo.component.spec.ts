import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProximoComponent } from './proximo.component';

describe('ProximoComponent', () => {
  let component: ProximoComponent;
  let fixture: ComponentFixture<ProximoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProximoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProximoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
