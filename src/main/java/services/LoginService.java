package services;

import entity.Account;
import exeptions.InvalidDataException;

public interface LoginService {

	Account login(String login, String password, int role) throws InvalidDataException;
}
