package com.skolamaric.model;


	public class Student {
		private String ime;
		private String prezime;
		private int godinaFakulteta;
		private boolean aktivanStudent;
		private String brojIndeksa;

		public Student() {
			this.brojIndeksa = "";
		}
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
		public String getPrezime() {
			return prezime;
		}
		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}
		public int getGodinaFakulteta() {
			return godinaFakulteta;
		}
		public void setGodinaFakulteta(int godinaFakulteta) {
			this.godinaFakulteta = godinaFakulteta;
		}
		
		
		public boolean isAktivanStudent() {
			return aktivanStudent;
		}

		public void setAktivanStudent(boolean aktivanStudent) {
			this.aktivanStudent = aktivanStudent;
		}

		public String getBrojIndeksa() {
			return brojIndeksa;
		}
		public void setBrojIndeksa(String brojIndeksa) {
			this.brojIndeksa = brojIndeksa;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (aktivanStudent ? 1231 : 1237);
			result = prime * result + ((brojIndeksa == null) ? 0 : brojIndeksa.hashCode());
			result = prime * result + godinaFakulteta;
			result = prime * result + ((ime == null) ? 0 : ime.hashCode());
			result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (aktivanStudent != other.aktivanStudent)
				return false;
			if (brojIndeksa == null) {
				if (other.brojIndeksa != null)
					return false;
			} else if (!brojIndeksa.equals(other.brojIndeksa))
				return false;
			if (godinaFakulteta != other.godinaFakulteta)
				return false;
			if (ime == null) {
				if (other.ime != null)
					return false;
			} else if (!ime.equals(other.ime))
				return false;
			if (prezime == null) {
				if (other.prezime != null)
					return false;
			} else if (!prezime.equals(other.prezime))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Ime: " + ime + ", prezime: " + prezime + ", godina fakulteta: " + godinaFakulteta
					+ ", da li je student aktivan: " + aktivanStudent + ", broj indeksa: " + brojIndeksa + ".";
		}
		
	}


