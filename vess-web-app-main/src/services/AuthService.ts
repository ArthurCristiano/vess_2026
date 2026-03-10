import api from "./api";

export interface User {
  id: number;
  username: string;
  email: string;
  institution: string;
  country: string;
  state: string;
  password?: string;
  city: string;
  roles: string[];
  admin: boolean;
}
export interface LoginResponse {
  token: string;
  user: User;
}

export async function login(username: string, password: string): Promise<LoginResponse> {
  const { data } = await api.post<LoginResponse>("/auth/login", { username, password });
  return data;
}

export async function register(username: string, email: string, password: string): Promise<User> {
  const { data } = await api.post<User>("/auth/register", { username, email, password });
  return data;
}

export function logout() {
  localStorage.removeItem("token");
}
