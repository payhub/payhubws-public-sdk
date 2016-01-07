class UserRole
  include JsonSerializer
  ATTRS=[:userRoles,:errors]
  attr_accessor *ATTRS
  ALL_USER_ROLE_LINK="userRole/roles"

  def initialize

  end
end
class Roles
  include JsonSerializer
  ATTRS=[:numberOfUsers,:roleName,:roleId]
  attr_accessor *ATTRS

  def initialize

  end

end