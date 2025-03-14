/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Cars;
import entity.Customer;
import entity.Parts;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TNO
 */
public class SaleDAO extends DBUtils {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conn;
    private List<Customer> customers;

    public SaleDAO() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            conn = getConnection();
        }
        customers = new ArrayList<>();
    }

    public List<Customer> findAll() {
        String sql = "SELECT custID, custName, phone, sex, cusAddress FROM Customer";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustID(rs.getInt("custID"));
                customer.setCustName(rs.getString("custName"));
                customer.setPhone(rs.getInt("phone"));
                customer.setSex(rs.getString("sex"));
                customer.setCusAddress(rs.getString("cusAddress"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customers;
    }

    public Customer findById(int id) {
        String sql = "SELECT custID, custName, phone, sex, cusAddress FROM Customer WHERE custID = ?";
        Customer customer = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setCustID(rs.getInt("custID"));
                customer.setCustName(rs.getString("custName"));
                customer.setPhone(rs.getInt("phone"));
                customer.setSex(rs.getString("sex"));
                customer.setCusAddress(rs.getString("cusAddress"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customer;
    }

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (custID, custName, phone, sex, cusAddress) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustID());
            ps.setString(2, customer.getCustName());
            ps.setInt(3, customer.getPhone());
            ps.setString(4, customer.getSex());
            ps.setString(5, customer.getCusAddress());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET custName = ?, phone = ?, sex = ?, cusAddress = ? WHERE custID = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustName());
            ps.setInt(2, customer.getPhone());
            ps.setString(3, customer.getSex());
            ps.setString(4, customer.getCusAddress());
            ps.setInt(5, customer.getCustID());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
        return false;
    }

    public boolean deleteCustomer(int custID) {
        String sql = "DELETE FROM Customer WHERE custID = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, custID);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
        return false;
    }

    public List<Customer> searchCustomerByName(String name) {
        String sql = "SELECT * FROM Customer WHERE custName LIKE ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustID(rs.getInt("custID"));
                customer.setCustName(rs.getString("custName"));
                customer.setPhone(rs.getInt("phone"));
                customer.setSex(rs.getString("sex"));
                customer.setCusAddress(rs.getString("cusAddress"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return customers;
    }

    public boolean addCar(Cars car) {
        String sql = "INSERT INTO Cars (carID, serialNumber, model, colour, year) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, car.getCarId());
            ps.setString(2, car.getSerialNumber());
            ps.setString(3, car.getModel());
            ps.setString(4, car.getColour());
            ps.setInt(5, car.getYear());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public List<Cars> getAllCars() {
        List<Cars> cars = new ArrayList<>();
        String sql = "SELECT * FROM Cars";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cars car = new Cars(
                        rs.getInt("carID"),
                        rs.getString("serialNumber"),
                        rs.getString("model"),
                        rs.getString("colour"),
                        rs.getInt("year")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cars;
    }

    public Cars getCarById(int carID) {
        String sql = "SELECT * FROM Cars WHERE carID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, carID);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Cars(
                        rs.getInt("carID"),
                        rs.getString("serialNumber"),
                        rs.getString("model"),
                        rs.getString("colour"),
                        rs.getInt("year")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public boolean updateCar(Cars car) {
        String sql = "UPDATE Cars SET serialNumber = ?, model = ?, colour = ?, year = ? WHERE carID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, car.getSerialNumber());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getColour());
            ps.setInt(4, car.getYear());
            ps.setInt(5, car.getCarId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCar(int carID) {
        String sql = "DELETE FROM Cars WHERE carID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, carID);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public List<Cars> filterCart(String serialNumber, String model, Integer year) {
        List<Cars> cars = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Cars WHERE 1=1");

        if (serialNumber != null && !serialNumber.isEmpty()) {
            sql.append(" AND serialNumber LIKE ?");
        }
        if (model != null && !model.isEmpty()) {
            sql.append(" AND model LIKE ?");
        }
        if (year != null) {
            sql.append(" AND year = ?");
        }

        try {
            ps = conn.prepareStatement(sql.toString());

            int index = 1;
            if (serialNumber != null && !serialNumber.isEmpty()) {
                ps.setString(index++, "%" + serialNumber + "%");
            }
            if (model != null && !model.isEmpty()) {
                ps.setString(index++, "%" + model + "%");
            }
            if (year != null) {
                ps.setInt(index++, year);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Cars car = new Cars(
                        rs.getInt("carID"),
                        rs.getString("serialNumber"),
                        rs.getString("model"),
                        rs.getString("colour"),
                        rs.getInt("year")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cars;
    }

    public List<Parts> findAllParts() {
        List<Parts> parts = new ArrayList<>();
        String sql = "SELECT * FROM Parts";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Parts part = new Parts(
                        rs.getInt("partID"),
                        rs.getString("partName"),
                        rs.getDouble("purchasePrice"),
                        rs.getDouble("retailPrice")
                );
                parts.add(part);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return parts;
    }

    public Parts findByIdPart(int partID) {
        String sql = "SELECT * FROM Parts WHERE partID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, partID);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Parts(
                        rs.getInt("partID"),
                        rs.getString("partName"),
                        rs.getDouble("purchasePrice"),
                        rs.getDouble("retailPrice")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public boolean insertPart(Parts part) {
        String sql = "INSERT INTO Parts (partID, partName, purchasePrice, retailPrice) VALUES (?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, part.getPartID());
            ps.setString(2, part.getPartName());
            ps.setDouble(3, part.getPurchasePrice());
            ps.setDouble(4, part.getRetailPrice());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean updatePart(Parts part) {
        String sql = "UPDATE Parts SET partName = ?, purchasePrice = ?, retailPrice = ? WHERE partID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, part.getPartName());
            ps.setDouble(2, part.getPurchasePrice());
            ps.setDouble(3, part.getRetailPrice());
            ps.setInt(4, part.getPartID());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean deletePart(int partID) {
        String sql = "DELETE FROM Parts WHERE partID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, partID);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

}
